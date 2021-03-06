/*
 * Copyright (C) 2017 Sylvain Leroy - BYOSkill Company All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of the MIT license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the MIT license with
 * this file. If not, please write to: sleroy at byoskill.com, or visit : www.byoskill.com
 *
 */
package com.byoskill.spring.cqrs.commands;

import java.util.Optional;

/**
 * This interface defines a command handler that produces also events after the execution of the command.
 * @param <R> the result type.
 */
public interface EventThrower<R> {

    /**
     * Event Triggered in case of failures.
     *
     * @param failure the failure
     * @return the event that should be thrown (null does not send event)
     */
    Optional<Object> eventOnFailure(Throwable failure);

    /**
     * Event triggered on success.
     *
     * @param result the result
     * @return the event that should be thrown (null does not send event)
     */
    Optional<Object> eventOnSuccess(R result);
}
