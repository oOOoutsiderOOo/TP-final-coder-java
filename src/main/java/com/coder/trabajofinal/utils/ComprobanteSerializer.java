package com.coder.trabajofinal.utils;

import java.io.IOException;

import com.coder.trabajofinal.models.entities.Comprobante;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ComprobanteSerializer extends StdSerializer<Comprobante> {
    public ComprobanteSerializer() {
        this(null);
    }

    public ComprobanteSerializer(Class<Comprobante> t) {
        super(t);
    }

    @Override
    public void serialize(
            Comprobante value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getComprobanteId());
        jgen.writeStringField("fecha", value.getFecha().toString());
        jgen.writeNumberField("total", value.getTotal());

        jgen.writeObjectFieldStart("cliente");
        jgen.writeNumberField("clienteId", value.getCliente().getClienteId());
        jgen.writeNumberField("dni", value.getCliente().getDNI());
        jgen.writeStringField("nombre", value.getCliente().getNombre());
        jgen.writeStringField("apellido", value.getCliente().getApellido());
        jgen.writeEndObject();

        jgen.writePOJOField("productoVenta", value.getProductoVenta());

        jgen.writeEndObject();
        // jgen.writeObjectField("comprobante", value.getComprobante());
    }
}
