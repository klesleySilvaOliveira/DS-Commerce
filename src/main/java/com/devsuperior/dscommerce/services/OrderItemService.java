package com.devsuperior.dscommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.OrderItemDTO;
import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	@Autowired
	private ProductService productService;
	
	@Transactional
	public OrderItemDTO insert(OrderItemDTO dto, Order order) {
		
		OrderItem orderItem = new OrderItem();
		orderItem.setPrice(dto.getPrice());
		orderItem.setQuantity(dto.getQuantity());
		orderItem.setProduct(productService.findByIdProtected(dto.getProductId()));
		orderItem.setOrder(order);
		
		orderItem = repository.save(orderItem);
		
		return new OrderItemDTO(orderItem);
	}
	
	@Transactional
	protected List<OrderItem> insertAllProtected(List<OrderItem> orderItems) {
				
		return repository.saveAll(orderItems);
		
	}
}
