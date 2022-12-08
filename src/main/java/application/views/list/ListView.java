package application.views.list;
import Creation.CreateWorker;
import application.Service.AccessingData;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Worker User Interface")
@Route(value = "")
public class ListView extends VerticalLayout {
    AccessingData data;
    Grid<CreateWorker> grid = new Grid<>(CreateWorker.class);
    TextField filterText = new TextField();
    WorkerForm form;

    public ListView(AccessingData data) {
        this.data = data;
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        form = new WorkerForm(data.findAllHours(),data.findAllSpec());
        form.setWidth("25em");
        form.addListener(WorkerForm.SaveEvent.class, this::saveContact);
        form.addListener(WorkerForm.DeleteEvent.class, this::deleteContact);
        form.addListener(WorkerForm.CloseEvent.class, e -> closeEditor());

        FlexLayout content = new FlexLayout(grid, form);
        content.setFlexGrow(2, grid);
        content.setFlexGrow(1, form);
        content.setFlexShrink(0, form);
        content.addClassNames("content", "gap-m");
        content.setSizeFull();

        add(getToolbar(), content);
        updateList();
        closeEditor();
        grid.asSingleSelect().addValueChangeListener(event ->
                editContact(event.getValue()));
    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName");
        grid.addColumn(contact -> contact.getHours().getName()).setHeader("Hours");
        grid.addColumn(contact -> contact.getSpec().getName()).setHeader("Spec");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add contact");
        addContactButton.addClickListener(click -> addContact());

        HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void saveContact(WorkerForm.SaveEvent event) {
        data.saveContact(event.getContact());
        updateList();
        closeEditor();
    }

    private void deleteContact(WorkerForm.DeleteEvent event) {
        data.deleteWorker(event.getContact());
        updateList();
        closeEditor();
    }

    public void editContact(CreateWorker worker) {
        if (worker == null) {
            closeEditor();
        } else {
            form.setContact(worker);
            form.setVisible(true);
            addClassName("editing");
        }
    }

    void addContact() {
        grid.asSingleSelect().clear();
        editContact(new CreateWorker());
    }

    private void closeEditor() {
        form.setContact(null);
        form.setVisible(false);
        removeClassName("editing");
    }

    private void updateList() {
        grid.setItems(data.findAllWorkers(filterText.getValue()));
    }
}
