#!/bin/bash

echo "🕐 Timestamp Converter - Deployment Script"
echo "=========================================="
echo ""

# Check if Python is available
if command -v python3 &> /dev/null; then
    PYTHON_CMD="python3"
elif command -v python &> /dev/null; then
    PYTHON_CMD="python"
else
    echo "❌ Python is not installed. Please install Python to run the server."
    exit 1
fi

# Kill any existing server on port 8000
echo "🔄 Stopping any existing server on port 8000..."
pkill -f "python.*http.server.*8000" 2>/dev/null || true
sleep 2

# Start the server
echo "🚀 Starting timestamp converter website..."
echo "📁 Serving files from: $(pwd)"
echo ""

# Start server in background
$PYTHON_CMD -m http.server 8000 &
SERVER_PID=$!

# Wait a moment for server to start
sleep 3

echo "✅ Website is now running!"
echo ""
echo "🌐 Access your website at:"
echo "   Local:     http://localhost:8000"
echo "   Network:   http://$(hostname -I | awk '{print $1}'):8000"
echo ""
echo "📱 Features available:"
echo "   • Convert any date format to timestamp"
echo "   • Support for relative dates (tomorrow, yesterday, etc.)"
echo "   • Click timestamps to copy to clipboard"
echo "   • Real-time conversion as you type"
echo "   • Beautiful responsive design"
echo ""
echo "🛑 To stop the server, press Ctrl+C or run:"
echo "   kill $SERVER_PID"
echo ""

# Test if server is responding
if curl -s "http://localhost:8000" > /dev/null; then
    echo "✅ Server is responding correctly!"
else
    echo "❌ Server may not be responding. Please check manually."
fi

echo ""
echo "🎉 Ready to use! Open your browser and navigate to the URL above."

# Keep script running to show server output
wait $SERVER_PID