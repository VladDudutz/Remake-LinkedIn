package org.hbrs.se2.project.views.studentViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.textfield.TextField;
import org.hbrs.se2.project.control.ProfileControl;
import org.hbrs.se2.project.dtos.StudentHasMajorDTO;
import org.hbrs.se2.project.dtos.UserDTO;
import org.hbrs.se2.project.repository.StudentHasMajorRepository;
import org.hbrs.se2.project.util.Globals;
import org.hbrs.se2.project.views.AppView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = Globals.Pages.PROFILE_VIEW, layout = AppView.class)
@PageTitle("Profile")
public class ProfileView extends Div {

    private final ProfileControl profileControl;

    public ProfileView(ProfileControl profileControl, ProfileControl profileControl1){
        this.profileControl = profileControl1;

        setSizeFull();

        Button save = new Button("save");
        Button delete = new Button("delete");
        Button undo = new Button("undo");

        TextField major = new TextField("Major");
        // can be removed for now
        // placeholder will not work because there can be multiple majors and
        // placeholder would only work for one string
        // major.setPlaceholder(profileControl.getMajorOfStudent(this.getCurrentUser().getUserid()));

        // print out all majors of a student in console
        List<String> majors = profileControl.getMajorOfStudent(this.getCurrentUser().getUserid());

        Grid<String> gridMajors = new Grid<>();
        gridMajors.addColumn(ValueProvider.identity());
        gridMajors.setItems(majors);
        add(gridMajors);




        for (Object o : majors) {
            //gridMajors.addColumn(ValueProvider.identity());
            System.out.println(o);
        }



        TextField university = new TextField("University");
        university.setValue(profileControl.getUniversityOfStudent(this.getCurrentUser().getUserid()));

        TextField topic = new TextField("Topics");
        List<String> topics = profileControl.getTopicOfStudent(this.getCurrentUser().getUserid());
        Grid<String> gridTopics = new Grid<>();
        gridTopics.addColumn(ValueProvider.identity());
        gridTopics.setItems(topics);
        add(gridTopics);

        for (Object o : topics) {
            System.out.println(o);
        }

        TextField skill = new TextField("Skills");
        List<String> skills = profileControl.getSkillOfStudent(this.getCurrentUser().getUserid());
        Grid<String> gridSkills = new Grid<>();
        gridSkills.addColumn(ValueProvider.identity());
        gridSkills.setItems(skills);
        add(gridSkills);

        for (Object o : skills){
            System.out.println(o);
        }

        FormLayout formLayout =  new FormLayout();
        formLayout.add(major,university,delete, undo,topic,skill);
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0",1));
        add(formLayout);
        add(save);

        delete.addClickListener((buttonClickEvent -> {
            String universitySaved = profileControl.getUniversityOfStudent(this.getCurrentUser().getUserid());
            profileControl.updateUniversity("", this.getCurrentUser().getUserid());
            university.setValue(profileControl.getUniversityOfStudent(this.getCurrentUser().getUserid()));
            undo.addClickListener(buttonClickEvent1 -> {
                profileControl.updateUniversity(universitySaved, this.getCurrentUser().getUserid());
                university.setValue(universitySaved);
            });

        }));

        save.addClickListener(buttonClickEvent -> {
            if (major.getValue() != null && !major.getValue().equals("")) {
                profileControl.updateStudyMajor(major.getValue(), this.getCurrentUser().getUserid());
            }
            if (university.getValue() != null && !university.getValue().equals("")) {
                profileControl.updateUniversity(university.getValue(), this.getCurrentUser().getUserid());
            }
            // topic input is just being printed out in the console
            // there is no call of the function profileControl.updateTopics to update topics in the database
            if (topic.getValue() != null && !topic.getValue().equals("")) {
                profileControl.updateTopics(topic.getValue(), this.getCurrentUser().getUserid());
            }
            // skills input is just being printed out in the console
            // there is no call of the function profileControl.updateSkills to update skills in the database
            if (skill.getValue() != null && !skill.getValue().equals("")) {
                profileControl.updateSkills(skill.getValue(), this.getCurrentUser().getUserid());            }
        });
        // initialization of the profileControl should be done
        // at the beginning of the ProfileView constructor
    }
    public UserDTO getCurrentUser() {
        UserDTO userDTO = (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
        System.out.println(userDTO.getUserid());
        return userDTO;
    }
}
