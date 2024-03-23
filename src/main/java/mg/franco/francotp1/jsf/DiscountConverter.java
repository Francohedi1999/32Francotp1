/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.franco.francotp1.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import mg.franco.francotp1.entity.Discount;
import mg.franco.francotp1.service.DiscountManager;


/**
 *
 * @author Franco
 */
@FacesConverter(value = "discountConverter", managed=true)
public class DiscountConverter implements Converter<Discount>{
    
    @Inject
    private DiscountManager discountManager;

    /**
     * Creates a new instance of DiscountConverter
     */
    public DiscountConverter() {
    }

    @Override
    public Discount getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) return null;
        return discountManager.findById(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Discount discount) {
        if (discount == null) return "";
        return discount.getCode();
    }
    
}
