package myPresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
    //atributos
    private JButton myPhoto, myHobby, myExpectations;
    private JPanel containerButtons, containerImage;
    private Listener listener;
    private Title title;
    private JLabel imageLabel;
    private JTextArea expectativesText;

    //metodos
    public GUI(){
        initGUI();
        this.setTitle("Mi Presentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Definir container y Layout del JFrame
        //Crear objetos Escucha y Control
        //Configurar JComponents

        title = new Title("Hola me llamo Jhonier, para conocerme oprime los botones", Color.BLACK); // Crear un título personalizado
        myPhoto = new JButton("Este soy yo"); // Crear botón
        myHobby = new JButton("Mis hobbies");
        myExpectations = new JButton("Creo que..");
        containerButtons = new JPanel(); // Crear un panel
        containerImage = new JPanel();
        listener = new Listener(); // Crear un objeto de escucha de eventos de acción
        imageLabel = new JLabel(); // Crear una etiqueta de imagen
        expectativesText = new JTextArea(10, 12); // Crear un área de texto de expectativas

        containerImage.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi...", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.SERIF,Font.ITALIC,16), Color.BLACK));
        // Establecer borde al panel de la imagen con un título personalizado

        containerImage.setLayout(new GridBagLayout()); // Cambiar el layout del panel de imagen a GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints(); // Crear una instancia de GridBagConstraints
        gbc.gridx = 0; // Establecer la posición x en la celda de la cuadrícula
        gbc.gridy = 0; // Establecer la posición y en la celda de la cuadrícula
        gbc.anchor = GridBagConstraints.CENTER; // Establecer la alineación en el centro
        containerImage.add(imageLabel, gbc); // Agregar la etiqueta de imagen al panel de la imagen

        containerButtons.add(myPhoto); // Agregar el botón "This is me" al panel de botones
        containerButtons.add(myHobby); // Agregar el botón "This is my passion" al panel de botones
        containerButtons.add(myExpectations); // Agregar el botón "I expect to get the best of you" al panel de botones

        myPhoto.addMouseListener(listener); // Agregar el escucha de eventos de acción al botón "This is me"
        myHobby.addMouseListener(listener); // Agregar el escucha de eventos de acción al botón "This is my passion"
        myExpectations.addMouseListener(listener); // Agregar el escucha de eventos de acción al botón "I expect to get the best of you"

        this.add(title, BorderLayout.NORTH); // Agregar el título en la parte superior de la ventana
        this.add(containerButtons, BorderLayout.SOUTH); // Agregar el panel de botones en la parte inferior de la ventana
        this.add(containerImage, BorderLayout.CENTER); // Agregar el panel de imagen y texto en el centro de la ventana
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI myGui = new GUI();
            } // crea una instancia de la GUI
        });
    }

    private class Listener extends MouseAdapter implements  KeyListener {

        private ImageIcon image;

        /**
         * @param e the event to be processed
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==myPhoto){
                this.image = new ImageIcon(getClass().getResource("/resources/yo.jpg"));
                Image scaledImage = image.getImage().getScaledInstance(270, 250, Image.SCALE_SMOOTH);
                image = new ImageIcon(scaledImage);
                imageLabel.setIcon(image);
                myPhoto.setCursor(new Cursor(Cursor.HAND_CURSOR));

            }

            else if(e.getSource() == myHobby){

                if(e.getClickCount()==2){
                this.image = new ImageIcon(getClass().getResource("/resources/hobies.png"));
                Image scaledImage = image.getImage().getScaledInstance(270, 250, Image.SCALE_SMOOTH);
                image = new ImageIcon(scaledImage);
                imageLabel.setIcon(image);}
            }

            revalidate();
            repaint();

        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void mousePressed(MouseEvent e) {

        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void mouseExited(MouseEvent e) {

        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void keyTyped(KeyEvent e) {

        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void keyPressed(KeyEvent e) {

            containerImage.removeAll();

            if(e.getSource()==myPhoto){
                if(e.VK_M==e.getKeyCode()){
                    expectativesText.setText("creo que va ser un gran curso");
                    expectativesText.setBackground(null);
                    expectativesText.setForeground(Color.BLACK);
                    containerImage.add(expectativesText);
                }
                revalidate();
                repaint();

            }

            else if(e.getSource()==myHobby){
                if(e.VK_M==e.getKeyCode()){
                    expectativesText.setText("creo que va ser un gran curso");
                    expectativesText.setBackground(null);
                    expectativesText.setForeground(Color.BLACK);
                    containerImage.add(expectativesText);
                }
                revalidate();
                repaint();

            }else{
                if(e.VK_M==e.getKeyCode()){

                    expectativesText.setText("creo que va ser un gran curso");
                    expectativesText.setBackground(null);
                    expectativesText.setForeground(Color.BLACK);
                    containerImage.add(expectativesText);

                }
                revalidate();
                repaint();
            }


        }

        /**
         * @param e the event to be processed
         */
        @Override
        public void keyReleased(KeyEvent e) {

        }


    }}