package com.example.springbootlivebook.JDBC;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;
import java.util.Map;


@Route("markgui")
public class MarkGui extends VerticalLayout {

    private TextField textFieldMark;
    private TextArea textArea;
    private Button button;
    private CarDao carDao;

    public MarkGui(CarDao carDao) {
        this.textFieldMark = new TextField("Mark");
        this.textArea = new TextArea();
        this.button = new Button("Pokaż");
        this.carDao = carDao;
        add(textFieldMark, textArea, button);
        button.addClickListener( x -> {
            List<Map<String, Object>> maps = carDao.showByMark(textFieldMark.getValue());
            textArea.setValue(maps.toString());
        });
    }
}
