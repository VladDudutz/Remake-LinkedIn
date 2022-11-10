package org.hbrs.se2.project.views.companyViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.hbrs.se2.project.control.JobControl;
import org.hbrs.se2.project.dtos.CompanyDTO;
import org.hbrs.se2.project.dtos.UserDTO;
import org.hbrs.se2.project.dtos.impl.JobDTOImpl;
import org.hbrs.se2.project.helper.navigateHandler;
import org.hbrs.se2.project.util.Globals;
import org.hbrs.se2.project.util.Utils;
import org.hbrs.se2.project.views.AppView;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Company - Create new Job Post / Job Ad
 */
@Route(value = Globals.Pages.NEW_ADD_VIEW, layout = AppView.class)
@PageTitle("New Job Ad")
public class NewJobAdView extends Div {
    @Autowired
    private JobControl jobControl;

    public NewJobAdView() {
        setSizeFull();
        H3 newAdText = new H3();
        newAdText.setText("Joberstellung");

        // Job title text area
        TextArea title = new TextArea("Titel");
        int charLimitTitle = 100;
        title.setMaxLength(charLimitTitle);
        title.addValueChangeListener(e -> e.getSource().setHelperText(e.getValue().length() + "/" + charLimitTitle));

        // Job Description text area
        TextArea description = new TextArea("Beschreibung");
        int charLimitDescr = 1024;
        description.setMaxLength(charLimitDescr);
        description.addValueChangeListener(e -> e.getSource().setHelperText(e.getValue().length() + "/" + charLimitDescr));

        // Salary text field
        TextField salary = new TextField("Erwartete Bezahlung");
        // Location text field
        TextField location = new TextField("Arbeitsort");
        // post new job button
        Button postButton = new Button("Neuen Job erstellen");

        // new job ad form
        FormLayout formLayout = new FormLayout();
        formLayout.add(title, description, salary, location, postButton);
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1)
        );

        postButton.addClickListener(event -> {
            // get companyid from current user
            UserDTO currentUser = this.getCurrentUser();
            CompanyDTO comp = jobControl.getCompanyByUserid(currentUser.getUserid());
            int companyid = comp.getCompanyid();

            // create new jobDTOImpl
            JobDTOImpl job = new JobDTOImpl(
                    companyid, title.getValue(), description.getValue(), salary.getValue(), location.getValue());

            // check if all input fields were filled out
            if(Utils.checkIfInputEmpty(
                    new String[]{job.getTitle(), job.getDescription(), job.getSalary(), job.getLocation()})) {
                // error dialog
                Utils.makeDialog("Fülle bitte alle Felder aus");
                throw new Error("Nicht alle Felder wurden ausgefüllt");
            }

            // call job control to save new job post entity
            jobControl.createNewJobPost(job);
            navigateHandler.navigateToMyAdsView();
        });

        // add all components to View
        add(newAdText);
        add(formLayout);
        this.setWidth("30%");
    }

    private UserDTO getCurrentUser() {
        return (UserDTO) UI.getCurrent().getSession().getAttribute(Globals.CURRENT_USER);
    }
}
