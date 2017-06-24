package kaaes.spotify.webapi.android.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.Map;

/**
 * Created by Ferg on 6/5/17.
 */

public class CurrentlyPlaying implements Parcelable{

    public Parcelable contextTemp;
    public Track item;
    public Long timestamp;
    public int progress_ms;
    public Boolean is_playing;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeValue(this.is_playing);
        dest.writeParcelable(this.contextTemp, 0);
        dest.writeParcelable(this.item, 0);
        dest.writeLong(this.timestamp);
        dest.writeInt(this.progress_ms);

    }

    public CurrentlyPlaying() {
    }

    protected CurrentlyPlaying(Parcel in) {
        this.contextTemp = in.readParcelable(Track.class.getClassLoader());
        this.item = in.readParcelable(Track.class.getClassLoader());
        this.is_playing = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.timestamp = in.readLong();
        this.progress_ms = in.readInt();
    }

    public static final Creator<CurrentlyPlaying> CREATOR = new Creator<CurrentlyPlaying>() {
        public CurrentlyPlaying createFromParcel(Parcel source) {
            return new CurrentlyPlaying(source);
        }

        public CurrentlyPlaying[] newArray(int size) {
            return new CurrentlyPlaying[size];
        }
    };
}
