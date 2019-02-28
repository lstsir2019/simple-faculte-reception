/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefacultereception.domain.rest.converter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anas
 * @param <T>
 * @param <Vo>
 */
public abstract class AbstractConverter<T, Vo> {

    public abstract T toItem(Vo vo);

    public abstract Vo toVo(T item);

    public List<T> toItem(List<Vo> vos) {
        if (vos == null || vos.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<T> items = new ArrayList();
            vos.forEach(vo
                    -> items.add(toItem(vo)));
            return items;
        }
    }

    public List<Vo> toVo(List<T> items) {
        if (items == null || items.isEmpty()) {
            return new ArrayList<>();
        } else {
            List<Vo> vos = new ArrayList();
            items.forEach(item
                    -> vos.add(toVo(item)));
            return vos;
        }
    }
}
