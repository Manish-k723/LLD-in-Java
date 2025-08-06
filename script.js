class TimestampConverter {
    constructor() {
        this.dateInput = document.getElementById('dateInput');
        this.convertBtn = document.getElementById('convertBtn');
        this.results = document.getElementById('results');
        this.exampleItems = document.querySelectorAll('.example-item');
        
        this.initEventListeners();
    }

    initEventListeners() {
        // Convert button click
        this.convertBtn.addEventListener('click', () => this.convertTimestamp());
        
        // Enter key in input
        this.dateInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') {
                this.convertTimestamp();
            }
        });
        
        // Example items click
        this.exampleItems.forEach(item => {
            item.addEventListener('click', () => {
                const example = item.getAttribute('data-example');
                this.dateInput.value = example;
                this.convertTimestamp();
            });
        });
        
        // Auto-convert on input change (with debounce)
        let debounceTimer;
        this.dateInput.addEventListener('input', () => {
            clearTimeout(debounceTimer);
            debounceTimer = setTimeout(() => {
                if (this.dateInput.value.trim()) {
                    this.convertTimestamp();
                } else {
                    this.clearResults();
                }
            }, 500);
        });
    }

    convertTimestamp() {
        const input = this.dateInput.value.trim();
        if (!input) {
            this.showError('Please enter a date or timestamp');
            return;
        }

        try {
            const result = this.parseInput(input);
            this.displayResults(result, input);
        } catch (error) {
            this.showError(`Unable to parse "${input}". ${error.message}`);
        }
    }

    parseInput(input) {
        // Clean and normalize input
        const cleanInput = input.toLowerCase().trim();
        
        // Handle relative dates
        if (this.isRelativeDate(cleanInput)) {
            return this.parseRelativeDate(cleanInput);
        }
        
        // Handle "now" or "current time"
        if (cleanInput === 'now' || cleanInput === 'current' || cleanInput === 'current time') {
            return new Date();
        }
        
        // Handle numeric timestamps (seconds or milliseconds)
        if (this.isNumericTimestamp(input)) {
            return this.parseNumericTimestamp(input);
        }
        
        // Handle various date formats
        return this.parseDate(input);
    }

    isRelativeDate(input) {
        const relativeTerms = [
            'today', 'tomorrow', 'yesterday',
            'next week', 'last week', 'this week',
            'next month', 'last month', 'this month',
            'next year', 'last year', 'this year'
        ];
        
        return relativeTerms.some(term => input.includes(term)) ||
               /\d+\s*(day|week|month|year)s?\s*(ago|from now)/.test(input) ||
               /in\s+\d+\s*(day|week|month|year)s?/.test(input);
    }

    parseRelativeDate(input) {
        const now = new Date();
        
        // Handle simple relative dates
        if (input === 'today') return now;
        if (input === 'tomorrow') {
            const tomorrow = new Date(now);
            tomorrow.setDate(now.getDate() + 1);
            return tomorrow;
        }
        if (input === 'yesterday') {
            const yesterday = new Date(now);
            yesterday.setDate(now.getDate() - 1);
            return yesterday;
        }
        
        // Handle "X days ago" or "X days from now"
        const daysMatch = input.match(/(\d+)\s*days?\s*(ago|from now)/);
        if (daysMatch) {
            const days = parseInt(daysMatch[1]);
            const direction = daysMatch[2] === 'ago' ? -1 : 1;
            const result = new Date(now);
            result.setDate(now.getDate() + (days * direction));
            return result;
        }
        
        // Handle "in X days"
        const inDaysMatch = input.match(/in\s+(\d+)\s*days?/);
        if (inDaysMatch) {
            const days = parseInt(inDaysMatch[1]);
            const result = new Date(now);
            result.setDate(now.getDate() + days);
            return result;
        }
        
        // Handle weeks
        const weeksMatch = input.match(/(\d+)\s*weeks?\s*(ago|from now)/);
        if (weeksMatch) {
            const weeks = parseInt(weeksMatch[1]);
            const direction = weeksMatch[2] === 'ago' ? -1 : 1;
            const result = new Date(now);
            result.setDate(now.getDate() + (weeks * 7 * direction));
            return result;
        }
        
        // Handle months
        const monthsMatch = input.match(/(\d+)\s*months?\s*(ago|from now)/);
        if (monthsMatch) {
            const months = parseInt(monthsMatch[1]);
            const direction = monthsMatch[2] === 'ago' ? -1 : 1;
            const result = new Date(now);
            result.setMonth(now.getMonth() + (months * direction));
            return result;
        }
        
        // Handle years
        const yearsMatch = input.match(/(\d+)\s*years?\s*(ago|from now)/);
        if (yearsMatch) {
            const years = parseInt(yearsMatch[1]);
            const direction = yearsMatch[2] === 'ago' ? -1 : 1;
            const result = new Date(now);
            result.setFullYear(now.getFullYear() + (years * direction));
            return result;
        }
        
        // Fallback to Date constructor
        return new Date(input);
    }

    isNumericTimestamp(input) {
        // Check if input is purely numeric (allowing for decimal points)
        return /^\d+\.?\d*$/.test(input.trim());
    }

    parseNumericTimestamp(input) {
        const timestamp = parseFloat(input);
        
        // Determine if it's seconds or milliseconds based on length
        // Timestamps after year 2000 in seconds: > 946684800
        // Timestamps after year 2000 in milliseconds: > 946684800000
        if (timestamp < 946684800) {
            throw new Error('Timestamp appears to be before year 2000');
        }
        
        if (timestamp < 946684800000) {
            // Likely seconds, convert to milliseconds
            return new Date(timestamp * 1000);
        } else {
            // Likely milliseconds
            return new Date(timestamp);
        }
    }

    parseDate(input) {
        // Try various date formats
        const formats = [
            // ISO formats
            input,
            
            // Handle DD/MM/YYYY and MM/DD/YYYY
            this.convertSlashDate(input),
            
            // Handle DD-MM-YYYY and MM-DD-YYYY
            this.convertDashDate(input),
            
            // Add time if missing for date-only inputs
            this.addTimeToDate(input)
        ].filter(Boolean);
        
        for (const format of formats) {
            const date = new Date(format);
            if (!isNaN(date.getTime())) {
                return date;
            }
        }
        
        throw new Error('Unrecognized date format');
    }

    convertSlashDate(input) {
        // Handle DD/MM/YYYY vs MM/DD/YYYY ambiguity
        const slashMatch = input.match(/^(\d{1,2})\/(\d{1,2})\/(\d{4})(?:\s+(.+))?$/);
        if (slashMatch) {
            const [, first, second, year, time] = slashMatch;
            const timeStr = time ? ` ${time}` : '';
            
            // Try DD/MM/YYYY first (European format)
            if (parseInt(first) <= 12 && parseInt(second) > 12) {
                return `${year}-${first.padStart(2, '0')}-${second.padStart(2, '0')}${timeStr}`;
            }
            // Try MM/DD/YYYY (US format)
            else if (parseInt(second) <= 12 && parseInt(first) > 12) {
                return `${year}-${second.padStart(2, '0')}-${first.padStart(2, '0')}${timeStr}`;
            }
            // Ambiguous case - default to MM/DD/YYYY (US format)
            else {
                return `${year}-${first.padStart(2, '0')}-${second.padStart(2, '0')}${timeStr}`;
            }
        }
        return null;
    }

    convertDashDate(input) {
        // Handle DD-MM-YYYY format
        const dashMatch = input.match(/^(\d{1,2})-(\d{1,2})-(\d{4})(?:\s+(.+))?$/);
        if (dashMatch) {
            const [, day, month, year, time] = dashMatch;
            const timeStr = time ? ` ${time}` : '';
            return `${year}-${month.padStart(2, '0')}-${day.padStart(2, '0')}${timeStr}`;
        }
        return null;
    }

    addTimeToDate(input) {
        // If input looks like a date without time, try adding default time
        if (/^\d{4}-\d{1,2}-\d{1,2}$/.test(input)) {
            return `${input}T00:00:00`;
        }
        return null;
    }

    displayResults(date, originalInput) {
        const unixTimestamp = Math.floor(date.getTime() / 1000);
        const millisTimestamp = date.getTime();
        
        const resultsHTML = `
            <div class="result-item">
                <h4>Unix Timestamp (seconds)</h4>
                <div class="timestamp" onclick="copyToClipboard('${unixTimestamp}')" title="Click to copy">
                    ${unixTimestamp}
                </div>
                <div class="date-info">
                    ${date.toLocaleString('en-US', { 
                        weekday: 'long', 
                        year: 'numeric', 
                        month: 'long', 
                        day: 'numeric',
                        hour: '2-digit',
                        minute: '2-digit',
                        second: '2-digit',
                        timeZoneName: 'short'
                    })}
                </div>
            </div>
            <div class="result-item">
                <h4>Milliseconds Timestamp</h4>
                <div class="timestamp" onclick="copyToClipboard('${millisTimestamp}')" title="Click to copy">
                    ${millisTimestamp}
                </div>
                <div class="date-info">
                    ISO String: ${date.toISOString()}
                </div>
            </div>
        `;
        
        this.results.innerHTML = resultsHTML;
    }

    showError(message) {
        this.results.innerHTML = `
            <div class="error-message">
                ❌ ${message}
            </div>
        `;
    }

    clearResults() {
        this.results.innerHTML = '';
    }
}

// Utility function for copying to clipboard
function copyToClipboard(text) {
    navigator.clipboard.writeText(text).then(() => {
        showCopyFeedback();
    }).catch(() => {
        // Fallback for older browsers
        const textArea = document.createElement('textarea');
        textArea.value = text;
        document.body.appendChild(textArea);
        textArea.select();
        document.execCommand('copy');
        document.body.removeChild(textArea);
        showCopyFeedback();
    });
}

function showCopyFeedback() {
    // Remove existing feedback
    const existing = document.querySelector('.copy-feedback');
    if (existing) {
        existing.remove();
    }
    
    // Create new feedback
    const feedback = document.createElement('div');
    feedback.className = 'copy-feedback';
    feedback.textContent = '📋 Copied to clipboard!';
    document.body.appendChild(feedback);
    
    // Remove after animation
    setTimeout(() => {
        feedback.remove();
    }, 2000);
}

// Initialize the converter when the page loads
document.addEventListener('DOMContentLoaded', () => {
    new TimestampConverter();
    
    // Show current timestamp on load
    const now = new Date();
    const currentTimestamp = Math.floor(now.getTime() / 1000);
    
    // Auto-populate with current time as example
    setTimeout(() => {
        document.getElementById('dateInput').placeholder = 
            `e.g., 2024-01-15, Jan 15 2024, tomorrow, now (current: ${currentTimestamp})`;
    }, 1000);
});