package com.payoyo.gestion_ferreteria.dto;

/**
 * DTO de salida para representar un producto con todos sus datos visibles en la API.
 * Este record es inmutable y representa un objeto plano sin lógica.
 */
public record ProductoResponseDTO(
    Long id,
    String nombre,
    String categoria,
    Double precio,
    Integer stock,
    Boolean activo
) {}
