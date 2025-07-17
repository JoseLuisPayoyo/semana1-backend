package com.payoyo.gestion_ferreteria.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.payoyo.gestion_ferreteria.dto.ProductoResponseDTO;
import com.payoyo.gestion_ferreteria.model.Producto; 
import com.payoyo.gestion_ferreteria.mapper.ProductoMapper;
import com.payoyo.gestion_ferreteria.repository.ProductoRepository;

@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {
    
    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private ProductoMapper productoMapper;

    @InjectMocks
    private ProductoServiceImpl productoService;

    private Producto producto1;
    private Producto producto2;

    @BeforeEach
    void setUp() {
        producto1 = new Producto();
        producto1.setId(1L);
        producto1.setNombre("Martillo");

        producto2 = new Producto();
        producto2.setId(2L);
        producto2.setNombre("Destornillador");
    }

    @Test
    void testFindAllProductos() {
        // GIVEN
        List<Producto> productos = Arrays.asList(producto1, producto2);

        ProductoResponseDTO productoDTO1 = new ProductoResponseDTO(
            producto1.getId(),
            producto1.getNombre(),
            null, // categoría
            null, // precio
            null, // stock
            null  // activo
        );

        ProductoResponseDTO productoDTO2 = new ProductoResponseDTO(
            producto2.getId(),
            producto2.getNombre(),
            null,
            null,
            null,
            null
        );

        when(productoRepository.findAll()).thenReturn(productos);
        when(productoMapper.toDTO(producto1)).thenReturn(productoDTO1);
        when(productoMapper.toDTO(producto2)).thenReturn(productoDTO2);

        // WHEN
        List<ProductoResponseDTO> resultado = productoService.buscarTodos();

        // THEN
        assertThat(resultado).isNotNull();
        assertThat(resultado).hasSize(2);
        assertThat(resultado).containsExactly(productoDTO1, productoDTO2);

        verify(productoRepository).findAll();
        verify(productoMapper).toDTO(producto1);
        verify(productoMapper).toDTO(producto2);
    }
}
