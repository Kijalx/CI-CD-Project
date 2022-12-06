package application.views.list;

import Creation.CreateWorker;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import java.awt.*;

public class WorkerForm extends FormLayout {
    private CreateWorker worker;
    TextField fullName = new TextField("Full Name");
    TextField userIban = new TextField("IBAN");
    TextField userBic = new TextField("BIC");
    TextField userRate = new TextField("Rate");
    EmailField userEmail = new EmailField("Email");
    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button cancel = new Button("Cancel");
    Binder<CreateWorker> binder = new BeanValidationBinder<>(CreateWorker.class);

    public WorkerForm(){
        binder.bindInstanceFields(this);
        add(fullName,userIban,userBic,userRate,userEmail,createButtonLayout());
    }
    private HorizontalLayout createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, worker)));
        cancel.addClickListener(event -> fireEvent(new CloseEvent(this)));


        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, cancel);
    }

    public void setContact(CreateWorker worker) {
        this.worker = worker;
        binder.readBean(worker);
    }

    private void validateAndSave() {
        try {
            binder.writeBean(worker);
            fireEvent(new SaveEvent(this, worker));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    // Events
    public static abstract class WorkerFormEvent extends ComponentEvent<WorkerForm> {
        private CreateWorker worker;

        protected WorkerFormEvent(WorkerForm source, CreateWorker worker) {
            super(source, false);
            this.worker = worker;
        }

        public CreateWorker getContact() {
            return worker;
        }
    }

    public static class SaveEvent extends WorkerFormEvent {
        SaveEvent(WorkerForm source, CreateWorker worker) {
            super(source, worker);
        }
    }

    public static class DeleteEvent extends WorkerFormEvent {
        DeleteEvent(WorkerForm source, CreateWorker worker) {
            super(source, worker);
        }

    }

    public static class CloseEvent extends WorkerFormEvent {
        CloseEvent(WorkerForm source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}
