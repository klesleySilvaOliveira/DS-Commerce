package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderStatus;

public class OrderDTO {

	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private ClientDTO client;
	private PaymentDTO payment;
	private List<OrderItemDTO> items = new ArrayList<>();
	
	public OrderDTO() {
	}
	
	public OrderDTO(Long id, Instant moment, OrderStatus status, ClientDTO client, PaymentDTO payment) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}
	
	public OrderDTO(Order order) {
		id = order.getId();
		moment = order.getMoment();
		status = order.getStatus();
		client = new ClientDTO(order.getClient());
		payment = (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment());
		items = (order.getItems() == null) ? null : order.getItems().stream()
				.map(x -> new OrderItemDTO(x)).toList();
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public ClientDTO getClient() {
		return client;
	}

	public PaymentDTO getPayment() {
		return payment;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}
	
	public Double getTotal() {
		Double sum = 0.0;
		
		for (OrderItemDTO dto : items) {
			sum += dto.getSubTotal();
		}
		
		return sum;
	}
}
