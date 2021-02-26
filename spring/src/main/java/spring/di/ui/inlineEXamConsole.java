package spring.di.ui;

import spring.di.entity.Exam;

public class inlineEXamConsole implements ExamConsole {
    private Exam exam;
    public inlineEXamConsole(Exam exam) {
        this.exam = exam;
    }

    @Override
    public void print() {
        System.out.printf("total: %d", exam.total());
        System.out.printf("avg: %f", exam.avg());
    }
}
