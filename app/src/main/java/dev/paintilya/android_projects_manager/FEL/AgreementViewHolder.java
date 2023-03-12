package dev.paintilya.android_projects_manager.FEL;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import dev.paintilya.android_projects_manager.R;

public class AgreementViewHolder extends RecyclerView.ViewHolder {

    private TextView subject, content;

    public AgreementViewHolder(@NonNull View itemView) {
        super(itemView);
        subject = itemView.findViewById(R.id.agreement_tv_subject);
        content = itemView.findViewById(R.id.agreement_tv_content);
    }
    public TextView getSubject() {
        return subject;
    }

    public void setSubject(TextView subject) {
        this.subject = subject;
    }

    public TextView getContent() {
        return content;
    }

    public void setContent(TextView content) {
        this.content = content;
    }
}
