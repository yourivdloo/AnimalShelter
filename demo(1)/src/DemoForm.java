import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoForm {
    private JComboBox CmbSpecies;
    private JTextField TxtName;
    private JRadioButton RadMale;
    private JRadioButton RadFemale;
    private JTextField TxtBadHabits;
    private JButton BtnAddAnimal;
    private JList LstAnimal;
    private JTextField TxtReservor;
    private JButton BtnReserve;
    private JPanel DemoForm;
    private JTabbedPane tabbedPane1;
    private JTextField TxtProductName;
    private JList LstProduct;
    private JSpinner SpnPrice;
    private JButton BtnAddProduct;
    private JButton BtnDeleteProduct;

    public static void main(String[] args) {
        JFrame frame = new JFrame("DemoForm");
        frame.setContentPane(new DemoForm().DemoForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    Reservation reservation = new Reservation();
    Webshop webshop = new Webshop();

    private void RefreshAnimals()
    {
        LstAnimal.removeAll();
        LstAnimal.setListData(reservation.Animals().toArray());
        if(LstAnimal.getSelectedValue() != null) {
            BtnReserve.setEnabled(true);
        } else {
            BtnReserve.setEnabled(false);
        }
    }

    private void RefreshProducts(){
        LstProduct.removeAll();
        LstProduct.setListData(webshop.Products().toArray());
        if(LstProduct.getSelectedValue() != null) {
            BtnDeleteProduct.setEnabled(true);
        } else {
            BtnDeleteProduct.setEnabled(false);
        }
    }

    public DemoForm() {

        BtnAddAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gender gender = RadMale.isSelected() ? Gender.MALE : Gender.FEMALE;

                if (CmbSpecies.getSelectedItem().equals("Cat")){
                    reservation.NewCat(TxtName.getText(), gender, TxtBadHabits.getText());
                } else if (CmbSpecies.getSelectedItem().equals("Dog")){
                    reservation.NewDog(TxtName.getText(), gender);
                }
                RefreshAnimals();
            }
        });

        BtnReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animal animal = (Animal) LstAnimal.getSelectedValue();

                if (animal != null)
                {
                    animal.Reserve(TxtReservor.getText());
                    RefreshAnimals();
                }
            }
        });
        CmbSpecies.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CmbSpecies.getSelectedItem().equals("Dog")){
                    TxtBadHabits.setEnabled(false);
                } else {
                    TxtBadHabits.setEnabled(true);
                }
            }
        });
        LstAnimal.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Animal animal = (Animal) LstAnimal.getSelectedValue();
                if (animal != null && animal.IsReserved() == false) {
                    BtnReserve.setEnabled(true);
                } else{
                    BtnReserve.setEnabled(false);
                }
            }
        });
        BtnAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add product
                webshop.AddProduct(TxtProductName.getText(), (Integer) SpnPrice.getValue());
                RefreshProducts();
            }
        });
        BtnDeleteProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //delete product
                Product product = (Product) LstProduct.getSelectedValue();
                webshop.RemoveProduct(product);
                RefreshProducts();
            }
        });
        LstProduct.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Product product = (Product) LstProduct.getSelectedValue();
                if (product != null) {
                    BtnDeleteProduct.setEnabled(true);
                } else{
                    BtnDeleteProduct.setEnabled(false);
                }
            }
        });
    }
}
