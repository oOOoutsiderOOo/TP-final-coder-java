package com.coder.trabajofinal.utils;

import java.io.IOException;

import com.coder.trabajofinal.models.entities.Cliente;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ClienteSerializer extends StdSerializer<Cliente> {

    public ClienteSerializer() {
        this(null);
    }

    public ClienteSerializer(Class<Cliente> t) {
        super(t);
    }

    @Override
    public void serialize(
            Cliente value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeNumberField("id", value.getClienteId());
        jgen.writeNumberField("DNI", value.getDNI());
        jgen.writeStringField("nombre", value.getNombre());
        jgen.writeStringField("apellido", value.getApellido());
        // jgen.writeObjectField("comprobante", value.getComprobante());
        jgen.writeEndObject();
    }
}