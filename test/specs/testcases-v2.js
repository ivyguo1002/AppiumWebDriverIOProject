const HomePage = require('../pageobjects/home.page');
const CoursePage = require('../pageobjects/course.page');
const LessonPage = require('../pageobjects/lesson.page');
describe('tests', () => {
    beforeEach('Go to Home', () => {
        HomePage.goToHomePage();
    })
    /*
    Steps: 
    1. Start Guru99 App
    Expected: 
    1. App Name is displayed
    2. Course Category is displayed and highlighted
    3. Content of Course Category is listed and each item is enabled
    */
    it('testcase1', () => {
        expect(HomePage.appName).toHaveText('Guru99');
        expect(HomePage.courseCategory).toHaveText('Course Category');
        expect(HomePage.courseCategory).toBeDisplayed();
        expect(HomePage.courseCategory).toBeSelected();

        HomePage.courseCategoryItems.forEach((course) => {
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
        HomePage.courseCategoryItems[0].click();
        HomePage.waitForChildItemShown();

        HomePage.scrollDown();
        HomePage.sapBI.click();
        CoursePage.waitForLessonsShown();
        CoursePage.headings.forEach((heading) => {
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
    it.only('testcase3', () => {
        HomePage.courseList.click();
        HomePage.waitForCourseListItemShown();

        // scroll using UIAutomator command
        HomePage.scrollToItemAndClick('PHP');
        CoursePage.waitForLessonsShown();
        CoursePage.lession1.click();
        LessonPage.waitForLessonContentLoaded();
        expect(LessonPage.lessonTitle).toHaveText('What is PHP? Write your first PHP Program');
    }) 

})