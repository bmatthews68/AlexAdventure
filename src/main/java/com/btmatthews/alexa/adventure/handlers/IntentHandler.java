/*
 * Copyright (c) 2017 Brian Matthews <brian@btmatthews.com>
 *
 * All rights reserved. No warranty, explicit or implicit, provided.
 */

package com.btmatthews.alexa.adventure.handlers;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.SpeechletResponse;

public interface IntentHandler {

    boolean handles(String intentName);

    SpeechletResponse handle(Intent intent);
}
