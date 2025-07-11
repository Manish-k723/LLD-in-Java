package BuilderPattern;

import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects(List<String> subjects) {
        this.subjects = subjects;
        return this;
    }
}
