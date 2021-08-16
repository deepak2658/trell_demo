package com.example.demo.model.slots;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "slots")
public class Slots {
    @Transient
    public static final String SEQUENCE_NAME = "user_sequence";

    @Id
    Long id;

//    @Field("slot_1")
//    boolean slot1;
//
//    @Field("slot_2")
//    boolean slot2;
//
//    @Field("slot_1")
//    boolean slot3;
//
//    @Field("slot_4")
//    boolean slot4;

}
