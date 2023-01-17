package com.coder.trabajofinal.utils;

import java.io.IOException;

import com.coder.trabajofinal.models.entities.Producto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ProductoSerializer extends StdSerializer<Producto> {
    public ProductoSerializer() {
        this(null);
    }

    public ProductoSerializer(Class<Producto> t) {
        super(t);
    }

    @Override
    public void serialize(
            Producto value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("productoId", value.getProductoId());
        jgen.writeNumberField("codigo", value.getCodigo());
        jgen.writeStringField("nombre", value.getNombre());
        jgen.writeStringField("descripcion", value.getDescripcion());
        jgen.writeNumberField("precio", value.getPrecio());
        jgen.writeNumberField("stock", value.getStock());

        jgen.writeEndObject();
    }
}
