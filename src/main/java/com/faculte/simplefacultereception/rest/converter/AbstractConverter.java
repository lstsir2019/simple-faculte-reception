/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.rest.converter;

/**
 *
 * @author Anas
 */
public interface AbstractConverter<T,Vo> {
    public T toItem(Vo vo);
    public Vo toVo(T item);
}
