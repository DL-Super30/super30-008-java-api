package courses.com;


class CourseNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CourseNotFoundException(Long id) {
        super("Course not found with id " + id);
    }
}
