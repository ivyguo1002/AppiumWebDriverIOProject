const Page = require("./page");

class CoursePage extends Page{
    /**
     * define elements
     */
    get headings() { return $$('//*[@resource-id="com.vector.guru99:id/heading_text"]');}
    get lession1() {
        const lesson1 = 'new UiSelector().text("Lesson #1")';
        return $(`android=${lesson1}`);
    }

    /**
     * define or overwrite page methods
     */
    waitForLessonsShown() {
        const topHeading = $('//*[@resource-id="com.vector.guru99:id/heading_text"]');
        topHeading.waitForExist({timeout: 10000});
    }

}

module.exports = new CoursePage();