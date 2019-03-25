package com.uhk.czernas.umteapp.model

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel

@Table(database = AppDatabase::class)
class UserDB: BaseModel() {

    @PrimaryKey(autoincrement = true)
    var id: Int? = 0

    @Column
    var name: String? = null

    @Column
    var lastName: String? = null

}