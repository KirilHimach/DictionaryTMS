package com.example.dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import java.util.Collections;

public class DictionaryController {
    public TextField input;
    private ObservableList<String> words = FXCollections.observableArrayList();
    public ListView<String> output;
    private MultipleSelectionModel<String> selectionModel;

    public void dtnAdd(ActionEvent actionEvent) {
        if (!input.getText().trim().isEmpty()) {
            if (!checkWords(input.getText())) {
                words.add(input.getText().trim());
                showAllWords();
            }
        }
        input.clear();
    }

    private boolean checkWords(String value) {
        return words.contains(value);
    }

    public void btnDelete(ActionEvent actionEvent) {
        selectionModel = output.getSelectionModel();
        words.remove(selectionModel.getSelectedItem());
        showAllWords();
    }

    private void showAllWords() {
        Collections.sort(words);
        output.setItems(words);
    }
}