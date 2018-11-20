package me.sshplendid.study.springkt.api.greeting

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Greeting (
    @Id @GeneratedValue
    val id: Int,
    val name: String = "World",
    val content: String,
    val sendDateTime: LocalDateTime = LocalDateTime.now()
)
