/**
* main page object containing all methods, selectors and functionality
* that is shared across all page objects
*/
module.exports = class Page {
    
    
    // scroll using touchAction
    scrollDown() {
        browser.touchAction([
            { action: 'press', x: 500, y: 1700 },
            { action: 'moveTo', x: 500, y: 1300 },
            'release'
        ]);
    }
}
