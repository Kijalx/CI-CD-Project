package application.views.list;
import Creation.CreateWorker;
import org.springframework.data.repository.CrudRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Employees")
@Route(value = "")
public class ListView extends VerticalLayout {
    public ListView() {

    }

}
