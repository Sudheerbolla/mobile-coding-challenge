package com.audiobookstask.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PodcastsModel(
    @SerializedName("id") var id: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("publisher") var publisher: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("description") var description: String? = null,
    var isFavourite: Boolean? = false
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(image)
        parcel.writeString(title)
        parcel.writeString(publisher)
        parcel.writeString(thumbnail)
        parcel.writeString(description)
        parcel.writeValue(isFavourite)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PodcastsModel> {
        override fun createFromParcel(parcel: Parcel): PodcastsModel {
            return PodcastsModel(parcel)
        }

        override fun newArray(size: Int): Array<PodcastsModel?> {
            return arrayOfNulls(size)
        }
    }

    override fun equals(other: Any?): Boolean {
        return this.id.equals((other as PodcastsModel).id)
    }

}
