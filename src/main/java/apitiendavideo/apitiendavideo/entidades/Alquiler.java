package apitiendavideo.apitiendavideo.entidades;

import java.sql.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;

@Entity
@Table(name = "alquiler")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_alquiler")
    @GenericGenerator(name = "secuencia_alquiler", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "fechaprestamo")
    private Date fechaPrestamo;

    @Column(name = "plazo")
    private int plazo;

    @Column(name = "precio")
    private double precio;

    @Column(name = "fechadevolucion")
    private Date fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "idinventario", referencedColumnName = "id")
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "idtercero", referencedColumnName = "id")
    private Tercero tercero;

    public long getId() {
        return id;
    }

    public Alquiler() {
    }

    public Alquiler(long id, Date fechaPrestamo, int plazo, double precio, Inventario inventario, Tercero tercero) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.plazo = plazo;
        this.precio = precio;
        this.inventario = inventario;
        this.tercero = tercero;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Tercero getTercero() {
        return tercero;
    }

    public void setTercero(Tercero tercero) {
        this.tercero = tercero;
    }

}
