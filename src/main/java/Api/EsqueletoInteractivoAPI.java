package Api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class EsqueletoInteractivoAPI extends JPanel {

    public enum ZonaEsqueleto {
        CABEZA, BRAZO_IZQUIERDO, BRAZO_DERECHO,
        TORSO, PIERNA_IZQUIERDA, PIERNA_DERECHA
    }

    public Map<ZonaEsqueleto, Color> zonasColoreadas;
    private Map<ZonaEsqueleto, Rectangle> areasZonas;
    public static Color colorSeleccion;

    public EsqueletoInteractivoAPI() {
        zonasColoreadas = new HashMap<>();
        areasZonas = new HashMap<>();
        colorSeleccion = Color.RED;
        
        // Inicializar áreas
        areasZonas.put(ZonaEsqueleto.CABEZA, new Rectangle());
        areasZonas.put(ZonaEsqueleto.TORSO, new Rectangle());
        areasZonas.put(ZonaEsqueleto.BRAZO_IZQUIERDO, new Rectangle());
        areasZonas.put(ZonaEsqueleto.BRAZO_DERECHO, new Rectangle());
        areasZonas.put(ZonaEsqueleto.PIERNA_IZQUIERDA, new Rectangle());
        areasZonas.put(ZonaEsqueleto.PIERNA_DERECHA, new Rectangle());
        
        setPreferredSize(new Dimension(400, 650));
        setBackground(Color.WHITE);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                manejarClic(e);
            }
        });
    }

    private void manejarClic(MouseEvent e) {
        ZonaEsqueleto zona = verificarClic(e.getX(), e.getY());
        if (zona != null) {
            if (e.getClickCount() == 1) { 
                zonasColoreadas.put(zona, colorSeleccion);
                System.out.println("Zona seleccionada: " + zona);
            }
            repaint();
        }
    }

    public void setColorSeleccion(Color color) {
        this.colorSeleccion = color;
    }

    public void limpiarSelecciones() {
        zonasColoreadas.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarEsqueleto(g);
    }

    private ZonaEsqueleto verificarClic(int x, int y) {
        for (Map.Entry<ZonaEsqueleto, Rectangle> entry : areasZonas.entrySet()) {
            if (entry.getValue().contains(x, y)) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected void dibujarEsqueleto(Graphics g) {
        int centroX = getWidth() / 2;
       
        // Dibujar y actualizar las áreas interactivas
        areasZonas.put(ZonaEsqueleto.CABEZA, 
            dibujarZona(g, ZonaEsqueleto.CABEZA, centroX-30, 50, 60, 60));
        
        areasZonas.put(ZonaEsqueleto.TORSO, 
            dibujarZona(g, ZonaEsqueleto.TORSO, centroX-40, 110, 80, 120));
        
        areasZonas.put(ZonaEsqueleto.BRAZO_IZQUIERDO, 
            dibujarZona(g, ZonaEsqueleto.BRAZO_IZQUIERDO, centroX-80, 120, 40, 100));
        
        areasZonas.put(ZonaEsqueleto.BRAZO_DERECHO, 
            dibujarZona(g, ZonaEsqueleto.BRAZO_DERECHO, centroX+40, 120, 40, 100));
        
        areasZonas.put(ZonaEsqueleto.PIERNA_IZQUIERDA, 
            dibujarZona(g, ZonaEsqueleto.PIERNA_IZQUIERDA, centroX-50, 230, 40, 120));
        
        areasZonas.put(ZonaEsqueleto.PIERNA_DERECHA, 
            dibujarZona(g, ZonaEsqueleto.PIERNA_DERECHA, centroX+10, 230, 40, 120));
    }
    public void colorearZona(ZonaEsqueleto zona) {
        if (zona != null) {
            this.zonasColoreadas.put(zona, this.colorSeleccion);
            this.repaint(); 
        }
    }
    private Rectangle dibujarZona(Graphics g, ZonaEsqueleto zona, int x, int y, int width, int height) {
        // Relleno de la zona
        g.setColor(zonasColoreadas.getOrDefault(zona, Color.LIGHT_GRAY));
        g.fillOval(x, y, width, height);
        
        // Borde de la zona
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
        
        return new Rectangle(x, y, width, height);
    }
}