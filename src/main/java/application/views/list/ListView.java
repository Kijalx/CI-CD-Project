package application.views.list;
import Creation.CreateWorker;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Worker User Interface")
@Route(value = "")
public class ListView extends VerticalLayout {
    Grid<CreateWorker> grid = new Grid<>(CreateWorker.class);
    TextField filterByName = new TextField();
    WorkerForm form;

    public ListView() {
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        configureForm();
        add(getToolbar(), getContent());
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, form);
        content.setFlexGrow(2,grid);
        content.setFlexGrow(1,form);
        content.addClassName("content");
        content.setSizeFull();
        return content;
    }

    private void configureForm() {
        form = new WorkerForm();
        form.setWidth("25em");
    }

    private void configureGrid() {
        grid.addClassNames("Employee-Grid");
        grid.setSizeFull();
        grid.setColumns("name", "iban", "bic", "rate");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
    private HorizontalLayout getToolbar() {
        filterByName.setPlaceholder("Filter by name...");
        filterByName.setClearButtonVisible(true);
        filterByName.setValueChangeMode(ValueChangeMode.LAZY);

        Button addWorkerButton = new Button("Create Worker");

        HorizontalLayout toolbar = new HorizontalLayout(filterByName, addWorkerButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }
}
