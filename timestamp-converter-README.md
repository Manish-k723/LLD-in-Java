# 🕐 Timestamp Converter

A beautiful, flexible web application that converts various date and time formats to numerical timestamps.

## Features

- **Flexible Input**: Supports multiple date formats including:
  - ISO dates (2024-01-15)
  - US format (Jan 15, 2024)
  - European format (15/01/2024)
  - Date with time (01-15-2024 14:30)
  - Relative dates (tomorrow, yesterday, today)
  - Natural language (now, 3 days ago, in 2 weeks)
  - Existing timestamps (1705334400)
  - ISO strings (2024-01-15T10:30:00Z)

- **Dual Output**: Provides both Unix timestamps (seconds) and millisecond timestamps
- **Copy to Clipboard**: Click on any timestamp to copy it to your clipboard
- **Real-time Conversion**: Auto-converts as you type (with debouncing)
- **Interactive Examples**: Click on format examples to try them instantly
- **Responsive Design**: Works perfectly on desktop and mobile devices

## How to Use

1. **Start the Server**:
   ```bash
   python3 -m http.server 8000
   ```

2. **Open in Browser**:
   Navigate to `http://localhost:8000`

3. **Enter a Date/Time**:
   - Type any date format in the input field
   - Click "Convert to Timestamp" or press Enter
   - Or click on the example formats to try them

4. **Copy Results**:
   - Click on any timestamp to copy it to your clipboard
   - Get both Unix timestamps (seconds) and millisecond timestamps

## Supported Formats

| Format Type | Example | Description |
|-------------|---------|-------------|
| ISO Date | `2024-01-15` | Standard ISO format |
| US Format | `Jan 15, 2024` | Month name format |
| DD/MM/YYYY | `15/01/2024` | European format |
| With Time | `01-15-2024 14:30` | Date with specific time |
| Relative | `tomorrow` | Relative to current date |
| Current | `now` | Current timestamp |
| Timestamp | `1705334400` | Existing Unix timestamp |
| ISO String | `2024-01-15T10:30:00Z` | Full ISO string |

## Technical Details

- **Frontend**: Vanilla HTML, CSS, and JavaScript
- **No Dependencies**: Works entirely in the browser
- **Modern Design**: Uses CSS Grid, Flexbox, and modern styling
- **Cross-browser**: Compatible with all modern browsers
- **Responsive**: Mobile-friendly design

## Files

- `index.html` - Main HTML structure
- `styles.css` - Modern CSS styling with animations
- `script.js` - JavaScript functionality for date parsing and conversion

Enjoy converting timestamps with ease! 🚀