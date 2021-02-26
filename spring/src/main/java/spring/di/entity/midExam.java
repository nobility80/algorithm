package spring.di.entity;

public class midExam implements Exam {
    private int kor;
    private int mat;
    private int eng;
    private int com;

    @Override
    public int total() {
        return kor+mat+eng+com;
    }

    @Override
    public float avg() {
        return total()/4.0f;
    }
}
