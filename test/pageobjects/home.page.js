const Page = require('./page');

class HomePage extends Page{
    /**
     * define elements
     */
    get appName() { return $('//*[@resource-id="android:id/action_bar_title"]'); }
    get courseCategory () { return $('//android.widget.HorizontalScrollView[@resource-id="com.vector.guru99:id/indicator"]//android.widget.TextView[1]'); }
    get courseCategoryItems() { return $$('//*[@resource-id="com.vector.guru99:id/lblListHeader"]'); }
    get home() { return $('//*[@resource-id="android:id/home"]'); }
    get sapBI() { 
        const sapBI = 'new UiSelector().text("SAP BI").resourceId("com.vector.guru99:id/lblListItem")';
        return $(`android=${sapBI}`);
    }

    get courseList() { 
        const courseList = 'new UiSelector().text("Course List")';
        return $(`android=${courseList}`);
    }

    /**
     * define or overwrite page methods
     */
    goToHomePage() {
        this.home.click();
    }
    
    waitForChildItemShown() {
        const childItem = $('//*[@resource-id="com.vector.guru99:id/lblListItem"]');
        childItem.waitForDisplayed({timeout: 5000});
    }

    waitForCourseListItemShown() {
        const courseListItem = $('//*[@resource-id="android:id/text1"]');
        courseListItem.waitForExist({timeout: 5000});
    }

    scrollToItemAndClick(item) {
        const itemMenu = 'new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text("'+item+'").resourceId("android:id/text1"))';
        $(`android=${itemMenu}`).click();
    }
    
}

module.exports = new HomePage();