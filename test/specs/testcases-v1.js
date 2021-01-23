describe('tests', () => {
    /*
    Steps: 
    1. Start Guru99 App
    Expected: 
    1. App Name is displayed
    2. Course Category is displayed and highlighted
    3. Content of Course Category is listed and each item is enabled
    */
    it('testcase1', () => {
        const home = $('//*[@resource-id="android:id/home"]');
        home.click();
        const appName = $('//*[@resource-id="android:id/action_bar_title"]');
        expect(appName).toHaveText('Guru99');
        const courseCategory = $('//android.widget.HorizontalScrollView[@resource-id="com.vector.guru99:id/indicator"]//android.widget.TextView[1]');
        expect(courseCategory).toHaveText('Course Category');
        expect(courseCategory).toBeDisplayed();
        expect(courseCategory).toBeSelected();

        const courseCategoryItems = $$('//*[@resource-id="com.vector.guru99:id/lblListHeader"]');
        courseCategoryItems.forEach((course) => {
            expect(course).toBeEnabled();
        });
    })

    /*
    Steps:
    1. Start Guru99 App
    2. Click on an item on the list view of Course Category, SAP
    3. Scroll to SAP BI
    4. Get the total child items
    Expected:
    1. The item SAP is clickable
    2. New window displays the content.
    */
    it('testcase2', () => {
        const home = $('//*[@resource-id="android:id/home"]');
        home.click();
        const courseCategoryItems = $$('//*[@resource-id="com.vector.guru99:id/lblListHeader"]');
        courseCategoryItems[0].click();

        const childItem = $('//*[@resource-id="com.vector.guru99:id/lblListItem"]');
        childItem.waitForExist({timeout: 5000});

        // scroll using touchAction
        browser.touchAction([
            { action: 'press', x: 500, y: 1700 },
            { action: 'moveTo', x: 500, y: 1300 },
            'release'
        ]);

        const sapBI = 'new UiSelector().text("SAP BI").resourceId("com.vector.guru99:id/lblListItem")';
        $(`android=${sapBI}`).click();
        const topHeading = $('//*[@resource-id="com.vector.guru99:id/heading_text"]');
        topHeading.waitForExist({timeout: 10000});

        const headings = $$('//*[@resource-id="com.vector.guru99:id/heading_text"]');
        headings.forEach((heading) => {
            console.log(heading.getText());
            expect(heading).toHaveTextContaining('Lesson');
        })
    })

    /**
     * Steps:
     * 1. Start Guru99 app
     * 2. Click on Course List
     * 3. Select PHP
     * 4. Click on Lesson 1
     * Expected:
     * 1. Verify title of lesson 1
     */
    it('testcase3', () => {
        const home = $('//*[@resource-id="android:id/home"]');
        home.click();
        const courseList = 'new UiSelector().text("Course List")';
        $(`android=${courseList}`).click();
        const courseListItem = $('//*[@resource-id="android:id/text1"]');
        courseListItem.waitForExist({timeout: 5000});

        // scroll using UIAutomator command
        const php = 'new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text("PHP").resourceId("android:id/text1"))';
        $(`android=${php}`).click();

        const lesson1 = 'new UiSelector().text("Lesson #1")';
        $(`android=${lesson1}`).waitForExist({timeout: 15000});

        $(`android=${lesson1}`).click();
        const lessonTitle = $('//*[@resource-id="com.vector.guru99:id/lesson_title"]');
        expect(lessonTitle).toHaveText('What is PHP? Write your first PHP Program');

    }) 

})