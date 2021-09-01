package com.example.Login.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.session.AbstractSessionEvent;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SessionRegistryImpl implements SessionRegistry, ApplicationListener<SessionDestroyedEvent> {



    @Override
    public List<Object> getAllPrincipals() {
        return null;
    }

    @Override
    public List<SessionInformation> getAllSessions(Object principal, boolean includeExpiredSessions) {
        return null;
    }

    @Override
    public SessionInformation getSessionInformation(String sessionId) {
        return null;
    }

    @Override
    public void refreshLastRequest(String sessionId) {

    }

    @Override
    public void registerNewSession(String sessionId, Object principal) {

    }

    @Override
    public void removeSessionInformation(String sessionId) {

    }

    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {

    }
}
