package com.example.springbootlivebook.JDBC;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Route("cargui")
public class CarGui extends VerticalLayout {

    private TextField textFieldId;
    private TextField textFieldMark;
    private TextField textFieldModel;
    private TextField textFieldColor;
    private Button buttonAdd;
    private Button buttonDelete;
    private CarDao carDao;

    @Autowired
    public CarGui(CarDao carDao) {
        this.textFieldId = new TextField("id");
        this.textFieldMark = new TextField("mark");
        this.textFieldModel = new TextField("model");
        this.textFieldColor = new TextField("color");
        this.buttonAdd = new Button("Dodaj");
        this.buttonDelete = new Button("Usuń wszystkie");
        this.carDao = carDao;
        buttonAdd.addClickListener(clickEvent-> {
            Car car = new Car(Long.parseLong(textFieldId.getValue()),textFieldMark.getValue(), textFieldModel.getValue(), textFieldColor.getValue());
            carDao.add(car);
        });
        buttonDelete.addClickListener(clickEvent -> {
             carDao.delete();
        });
        add(textFieldId,textFieldMark,textFieldModel,textFieldColor,buttonAdd, buttonDelete);
    }


}
