package com.example.correo_is.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.correo_is.R;
import com.example.correo_is.correo;

public class DataFragment extends Fragment {

    private ListView listView;
    private CorreosListener listener;

    private correo[] datos =
            new correo[]{
                    new correo("redsalud@gmail.com", "Este 29 de Junio estaremos atendiendo",
                            "De: redsalud@gmail.com" + '\n' + "Para: ivett.sotomayor@gmail.com" +
                                    '\n' + '\n' +"Este 29 de Junio estaremos atendiendo" +
                                    '\n' + '\n' +"Porque cuidar tu salud y la de tu familia es nuestro compromiso, " +
                                    "te comunicamos que el próximo sábado 29 de junio, nuestros Centros Médicos y " +
                                    "Clínicas Dentales RedSalud estarán abiertos con horarios de atención habituales " +
                                    "al del día sábado." +
                                    "RESERVA TU HORA"),

                    new correo("promociones@gmail.com", "Estimad@ no puedes perder esta oportunidad",
                            "De: promociones@gmail.com" + '\n' + "Para: ivett.sotomayor@gmail.com" +
                                    '\n' + '\n' +"Estimad@ no puedes perder esta oportunidad" +
                                    '\n' + '\n' +"No puedes perder esta oportunidad, llama ahora y se el ganador " +
                                    "de uno de los 100 premios de $1.000.000 de pesos y relajate este invierno."),

                    new correo("tiendaparis@gmail.com", "Tu pedido a sido preparado",
                            "De: tiendaparis@gmail.com" + '\n' + "Para: ivett.sotomayor@gmail.com" +
                                    '\n' + '\n' +"Tu pedido a sido preparado" +
                                    '\n' + '\n' +"Estimad@ gracias por su compra, su pedido esta siendo preparado" +
                                    "para llevarlo a su domicilio."),

                    new correo("lider@gmail.com", "Ofertas de la semana",
                            "De: lider@gmail.com" + '\n' + "Para: ivett.sotomayor@gmail.com" +
                                    '\n' + '\n' +"Ofertas de la semana" +
                                    '\n' + '\n' +"Grandes marcas a solo $1.000 pesos, Apurate no lo dejes pasar." +
                                    '\n' + "Promoción válida en Lider desde el 20 de junio al 17 de julio de 2019."),

                    new correo("appstore@gmail.com", "Apps para seguir eventos deportivos",
                            "De: appstore@gmail.com" + '\n' + "Para: ivett.sotomayor@gmail.com" +
                                    '\n' + '\n' + "Apps para seguir eventos deportivos" +
                                    '\n' + '\n' +"Sigue la magia del futbol" +
                                    '\n' + "Conoce las apps esenciales para disfrutar el evento, seguir de cerca " +
                                    "las noticias y mucho más. Conocelas AQUÍ")};

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_data, container, false);
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        listView = (ListView)getView().findViewById(R.id.listViewCorreo);

        listView.setAdapter(new AdaptadorCorreos(this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int pos, long id) {
                if (listener!=null) {
                    listener.onCorreoSeleccionado(
                            (correo)listView.getAdapter().getItem(pos));
                }
            }
        });
    }

    class AdaptadorCorreos extends ArrayAdapter<correo> {

        Activity context;

        AdaptadorCorreos(Fragment context) {
            super(context.getActivity(), R.layout.listitem_correo, datos);
            this.context = context.getActivity();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_correo, null);

            TextView lblDe = (TextView)item.findViewById(R.id.LblDe);
            lblDe.setText(datos[position].getDe());

            TextView lblAsunto = (TextView)item.findViewById(R.id.LblAsunto);
            lblAsunto.setText(datos[position].getAsunto());

            return(item);
        }
    }

    public interface CorreosListener {
        void onCorreoSeleccionado(correo c);
    }

    public void setCorreosListener(CorreosListener listener) {
        this.listener = listener;
    }
}
