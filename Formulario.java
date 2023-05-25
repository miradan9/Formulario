package FormularioHilos;
//VALERIA DANAE AGUAYO MIRANDA
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Formulario extends JFrame {

    private JTextArea textoTextArea;
    private ArrayList<String> preguntas;
    private JTextField respuestaTextField;
    private JButton enviarButton;

    public Formulario() {
        super("Formulario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Cargar imagen
        ImageIcon imagenIcono = new ImageIcon("familia.jpg");
        Image imagen = imagenIcono.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon imagenEscalada = new ImageIcon(imagen);
        JLabel imagenLabel = new JLabel(imagenEscalada);
        add(imagenLabel, BorderLayout.NORTH);

        textoTextArea = new JTextArea(10, 20);
        textoTextArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textoTextArea);
        add(scrollPane, BorderLayout.CENTER);

        respuestaTextField = new JTextField(20);
        add(respuestaTextField, BorderLayout.SOUTH);

        enviarButton = new JButton("Enviar");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarRespuesta();
            }
        });
        add(enviarButton, BorderLayout.EAST);

        preguntas = new ArrayList<>();
        preguntas.add("Pregunta 1: Anne is Paul's: ");
        preguntas.add("Pregunta 2: Jason and Emily are their: ");
        preguntas.add("Pregunta 3: Paul is Anne's: ");
        preguntas.add("Pregunta 4: Jason is Anne's: ");
        preguntas.add("Pregunta 5: Emily is Paul's: ");
        preguntas.add("Pregunta 6: Jason is Emily's: ");
        preguntas.add("Pregunta 7: Emily is Jason's:");
        preguntas.add("Pregunta 8: Paul and Anne are Jason's: ");

        mostrarPrimeraPregunta();

        pack();
        setLocationRelativeTo(null);
    }

    private void mostrarPrimeraPregunta() {
        textoTextArea.setText(preguntas.get(0));
    }

    private void mostrarSiguientePregunta() {
        int indiceActual = preguntas.indexOf(textoTextArea.getText());
        if (indiceActual < preguntas.size() - 1) {
            textoTextArea.setText(preguntas.get(indiceActual + 1));
            respuestaTextField.setText("");
        } else {
            textoTextArea.setText("¡Has respondido todas las preguntas!");
            respuestaTextField.setEnabled(false);
            enviarButton.setEnabled(false);
        }
    }

    private void validarRespuesta() {
        String respuestaUsuario = respuestaTextField.getText().trim();
        String preguntaActual = textoTextArea.getText();
        // Validar respuesta
        if (esRespuestaCorrecta(respuestaUsuario, preguntaActual)) {
            JOptionPane.showMessageDialog(this, "¡Respuesta correcta!");
        } else {
            JOptionPane.showMessageDialog(this, "Respuesta incorrecta");
        }
        mostrarSiguientePregunta();
    }

    private boolean esRespuestaCorrecta(String respuestaUsuario, String pregunta) {
        if (pregunta.contains("Pregunta 1")) {
            return respuestaUsuario.equalsIgnoreCase("wife");
        } else if (pregunta.contains("Pregunta 2")) {
            return respuestaUsuario.equalsIgnoreCase("siblings");
        } else if (pregunta.contains("Pregunta 3")) {
            return respuestaUsuario.equalsIgnoreCase("husband");
        } else if (pregunta.contains("Pregunta 4")) {
            return respuestaUsuario.equalsIgnoreCase("son");
        } else if (pregunta.contains("Pregunta 5")) {
            return respuestaUsuario.equalsIgnoreCase("daughter");
        } else if (pregunta.contains("Pregunta 6")) {
            return respuestaUsuario.equalsIgnoreCase("brother");
        } else if (pregunta.contains("Pregunta 7")) {
            return respuestaUsuario.equalsIgnoreCase("sister");
        } else if (pregunta.contains("Pregunta 8")) {
            return respuestaUsuario.equalsIgnoreCase("parents");
        }
        return false;
    }

    public static void main(String[] args) {
        Formulario formulario = new Formulario();
        formulario.setVisible(true);
    }
}
