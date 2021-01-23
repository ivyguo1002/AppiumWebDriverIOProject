const Page = require('./page');

class LessonPage extends Page {
    get lessonTitle() { return $('//*[@resource-id="com.vector.guru99:id/lesson_title"]'); }

    waitForLessonContentLoaded() {
        this.lessonTitle.waitForDisplayed({ timeout: 5000});
    }
}

module.exports = new LessonPage();