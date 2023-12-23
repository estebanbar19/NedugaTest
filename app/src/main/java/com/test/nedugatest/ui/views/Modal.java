package com.test.nedugatest.ui.views;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Html;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.test.nedugatest.R;
import com.test.nedugatest.domain.model.Product;

public class Modal {
    static Dialog modal;

    public static Modal Create(Product product, Context context){
        return new Modal(product, context);
    }

    public Modal(Product product, Context context) {
        modal = new Dialog(context);
        modal.requestWindowFeature(Window.FEATURE_NO_TITLE);
        modal.setCanceledOnTouchOutside(false);

        modal.setContentView(R.layout.modal_layout);
        modal.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        modal.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView calificacion, descripcion;
        ImageView image;
        Button closeButton;
        calificacion = modal.findViewById(R.id.modal_calification);
        descripcion = modal.findViewById(R.id.modal_description);
        image = modal.findViewById(R.id.modal_image);
        closeButton = modal.findViewById(R.id.modal_close_btn);

        calificacion.setText(Html.fromHtml("<b>Calificación:</b> " + product.getRating().getRate()));
        descripcion.setText(Html.fromHtml("<b>Descripción:</b> " + product.getDescription()));
        if(product.getImage() != null && !product.getImage().isEmpty()){
            Picasso.get().load(product.getImage()).fit().into(image);
        }

        closeButton.setOnClickListener(v -> modal.dismiss());
    }

    public void show(){
        modal.show();
    }
}
