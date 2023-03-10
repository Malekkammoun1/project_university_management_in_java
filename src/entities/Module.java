package entities;
import enumeration.ModuleType;
import enumeration.SessionState;
import enumeration.SessionType;
import interfaces.ModuleInterface;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@NoArgsConstructor
//@AllArgsConstructor

public class Module implements ModuleInterface {

    private int id;
    private String name;
    private float due;
    private String studyLevel;
    private ModuleType moduleType;

    private ArrayList<Session> sessions = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Group> groups =new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDue() {
        return due;
    }

    public void setDue(float due) {
        this.due = due;
    }

    public String getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }

    public ModuleType getModuleType() {
        return moduleType;
    }

    public void setModuleType(ModuleType moduleType) {
        this.moduleType = moduleType;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    private static int lastId=0;
    public Module() {
        this.id=++lastId;
    }

    public Module(String name, float due, String studyLevel, ModuleType moduleType, ArrayList<Session> sessions, ArrayList<Teacher> teachers, ArrayList<Group> groups) {
        this.id=++lastId;
        this.name = name;
        this.due = due;
        this.studyLevel = studyLevel;
        this.moduleType = moduleType;
        this.sessions = sessions;
        this.teachers = teachers;
        this.groups = groups;
    }

    @Override
    public String toString() {
        return  "Id : "+ id +"\nName : "+ name +"\nDue : "+due +"\nStudy Level : "+ studyLevel
                +"\nmodule type : "+ moduleType +"\nSession : " + sessions + "\nteachers : " + teachers+
                "\nGroup" + this.getGroupDetails();

    }

    private String getGroupDetails() {
        String result = "";
        for (int i = 0; i<groups.size();i++ ) {
            result = result + groups.get(i).groupDetails() + " ";
        }
        return result;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    @Override
    public void removeTeacher(int index) {
        int i=0;
        do{
            if (i == index){
                teachers.remove(teachers.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=teachers.size()));

    }


    public enum TeacherComponents{
        name,
        familyName,
        photo,
        due,
        PersonalEmail,
        WorkEmail ;


    }
    @Override
    public void updateTeacher(int index, Module.TeacherComponents featureToUpdate, Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){
                    case name:
                        teachers.get(index).setName((String) newInfo);
                        break;
                    case familyName:
                        teachers.get(index).setFamilyName(((String) newInfo));
                        break;
                    case photo:
                        teachers.get(index).setPhoto(((String) newInfo));
                        break;
                    case due:
                        teachers.get(index).setDue(((float) newInfo));
                        break;
                    case PersonalEmail:
                        teachers.get(index).setPersonalEmail(((String) newInfo));
                        break;

                    default:
                        teachers.get(index).setWorkEmail((String) newInfo);

                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=teachers.size()));
        if ((i == teachers.size()) && (i != index)){
            System.out.println("the teacher you seek to update does not exist ");

        }

    }

    @Override
    public Teacher getTeacher(int index) {
        return teachers.get(index);
    }


    @Override
    public List<Teacher> getTeacherByCriteria(TeacherComponents criteria, Object criteriaContent) {
        ArrayList<Teacher> teacherByCriteriaList = new ArrayList<Teacher>();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i) == criteriaContent) {
                teacherByCriteriaList.add(teachers.get(i));

            }

        }
        return teacherByCriteriaList;
    }

    @Override
    public void addSession(Session session) {
        sessions.add(session);

    }

    @Override
    public void removeSession(int index) {
        int i=0;
        do{
            if (i == index){
                sessions.remove(sessions.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=sessions.size()));


    }

    public enum SessionComponents{
        startTime,
        endTime,
        classroomNumber,
        goal,
        summary,
        tools,
        sessionState,
        sessionType,
        module;


    }
    @Override
    public void updateSession(int index, Module.SessionComponents featureToUpdate, Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){
                    case startTime:
                        sessions.get(index).setStartTime((LocalTime) newInfo);
                        break;
                    case endTime:
                        sessions.get(index).setEndTime(((LocalTime) newInfo));
                        break;
                    case classroomNumber:
                        sessions.get(index).setClassroomNumber(((String) newInfo));
                        break;
                    case goal:
                        sessions.get(index).setGoal(((String) newInfo));
                        break;
                    case summary:
                        sessions.get(index).setSummary(((String) newInfo));
                        break;
                    case tools:
                        sessions.get(index).setTools(((String) newInfo));
                        break;
                    case sessionState:
                        sessions.get(index).setSessionState(((SessionState) newInfo));
                        break;
                    case sessionType:
                        sessions.get(index).setSessionType(((SessionType) newInfo));
                        break;

                    default:
                        sessions.get(index).setModule((Module) newInfo);

                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=sessions.size()));
        if ((i == sessions.size()) && (i != index)){
            System.out.println("the session you seek to update does not exist ");

        }

    }

    @Override
    public Session getSession(int index) {
        return sessions.get(index);
    }

    //getAllSessions n3mlou appel lel getter mta3 arraylist mta3 sessions

    @Override
    public List<Session> getSessionByCriteria(SessionComponents criteria, Object criteriaContent) {
        ArrayList<Session> sessionByCriteriaList = new ArrayList<Session>();
        for (int i = 0; i < sessions.size(); i++) {
            if (teachers.get(i) == criteriaContent) {
                sessionByCriteriaList.add(sessions.get(i));

            }

        }
        return sessionByCriteriaList;
    }

    @Override
    public void addGroup(Group group) {
        groups.add(group);

    }

    @Override
    public void removeGroup(int index) {
        int i=0;
        do{
            if (i == index){
                groups.remove(groups.get(index));
            }
            else{
                i++;
            }
        }while ((i != index) || (i!=groups.size()));

    }


    public enum GroupComponents{
        name,
        studentsNumber,
        email,
        studyLevel;


    }

    @Override
    public void updateGroup(int index, Module.GroupComponents featureToUpdate, Object newInfo) {
        int i=0;
        do{

            if (i == index){
                switch(featureToUpdate){
                    case name:
                        groups.get(index).setName((String) newInfo);
                        break;
                    case studentsNumber:
                        groups.get(index).setStudentsNumber(((int) newInfo));
                        break;
                    case email:
                        groups.get(index).setEmail(((String) newInfo));
                        break;

                    default:
                        groups.get(index).setStudyLevel((String) newInfo);

                }

            }
            else{
                i++;
            }
        }while ((i != index) || (i!=groups.size()));
        if ((i == groups.size()) && (i != index)){
            System.out.println("the group you seek to update does not exist ");

        }

    }

    @Override
    public Group getGroup(int index) {
        return groups.get(index);
    }


    @Override
    public List<Group> getGroupByCriteria(Module.GroupComponents criteria, Object criteriaContent) {
        ArrayList<Group> groupByCriteriaList = new ArrayList<Group>();
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i) == criteriaContent) {
                groupByCriteriaList.add(groups.get(i));

            }

        }
        return groupByCriteriaList;
    }
}
