package com.routeplanner.routerplannerapi.android.studio.comment;

import com.routeplanner.routerplannerapi.android.studio.evrouter.Route;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class UpdateCommentRequest extends Route {
    private final UUID userId;
    private final UUID commentId;
    private final String comment;
}