package com.satis.cartservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CartDto implements Serializable {

    List<CartItemDto> listCartDto;

}
