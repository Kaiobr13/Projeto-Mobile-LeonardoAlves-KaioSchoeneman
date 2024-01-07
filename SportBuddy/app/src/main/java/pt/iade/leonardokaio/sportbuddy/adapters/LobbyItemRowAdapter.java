package pt.iade.leonardokaio.sportbuddy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pt.iade.leonardokaio.sportbuddy.R;
import pt.iade.leonardokaio.sportbuddy.models.LobbyItem;

public class LobbyItemRowAdapter extends RecyclerView.Adapter<LobbyItemRowAdapter.ViewHolder> {
    private ArrayList<LobbyItem> items;
    private LayoutInflater inflater;
    private ItemClickListener clickListener;

    public LobbyItemRowAdapter(Context context, ArrayList<LobbyItem> items){
        inflater = LayoutInflater.from(context);
        this.items = items;
        clickListener = null;
    }

    public void setOnClickListener(ItemClickListener listener){
        clickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.row_lobby_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        LobbyItem item = items.get(position);

        holder.titleLabel.setText(item.getTitle());
        holder.notesLabel.setText(item.getNotes());
        holder.modDateLabel.setText(item.getModDate());
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titleLabel;
        public TextView notesLabel;
        public TextView modDateLabel;

        public ViewHolder(View itemView){
            super(itemView);

            titleLabel = itemView.findViewById(R.id.title_label);
            notesLabel = itemView.findViewById(R.id.notes_label);
            modDateLabel = itemView.findViewById(R.id.modality_label);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view){
            if (clickListener != null){
                clickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
