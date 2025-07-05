package com.jose.sistema_productos.servicio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.jose.sistema_productos.dto.ProductoDTO;
import com.jose.sistema_productos.exception.RecursoNoEncontradoException;
import com.jose.sistema_productos.modelo.Categoria;
import com.jose.sistema_productos.modelo.Producto;
import com.jose.sistema_productos.repository.CategoriaRepository;
import com.jose.sistema_productos.repository.ProductoRepository;
import com.jose.sistema_productos.util.ProductoMapper;

public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @Override
    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll()
            .stream()
            .map(ProductoMapper::toDTO)
            .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Long id) {
        //1. buscar producto por su id
        Producto producto = productoRepository.findById(id)
            //2. Si no lo encentra, lanza exception
            .orElseThrow(() -> new RecursoNoEncontradoException("Producto no encontrado con id: " + id));
        //3. Si la encuentra, se convierte a DTO
        return ProductoMapper.toDTO(producto);
    }


    @Override
    public ProductoDTO creaProducto(ProductoDTO productoDTO) {
        //1. Buscar la categoria por ID
        Categoria categoria = categoriaRepository.findById(productoDTO.getCategoriaId())
            .orElseThrow(() -> new RecursoNoEncontradoException("Categoria no encontrda con id: " + productoDTO.getCategoriaId()));
        
        // 2. Convertir el DTO a entidad, pasando la categoría encontrada
        Producto producto = ProductoMapper.toEntity(productoDTO, categoria);
        
        // 3. Guardar el producto en la base de datos
        Producto productoGuardado = productoRepository.save(producto);

        // 4. Convertir la entidad guardada a DTO y devolverla
        return ProductoMapper.toDTO(productoGuardado);
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarProducto'");
    }

    @Override
    public void eliminarProducto(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarProducto'");
    }
    
    
}
