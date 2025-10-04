# Chrome Proxy Configuration Summary

This document summarizes the steps taken to resolve an issue where Google Chrome could not connect to a service (like ChatGPT) through a router-based proxy (PassWall), even though other browsers like Safari worked correctly.

## Problem Diagnosis

The root cause was that **Google Chrome was not detecting or using the system-wide proxy settings** configured in macOS. This was confirmed by checking `chrome://net-internals/#proxy`, which showed no effective proxy settings were being used. As a result, Chrome was attempting a direct connection, which was blocked.

## Solution

Since Chrome was ignoring the system-level proxy, the solution was to enforce proxy settings manually within Chrome using a browser extension.

### 1. Install a Proxy Management Extension

The **Proxy SwitchyOmega** extension was installed from the Chrome Web Store to gain direct control over Chrome's proxy settings.

### 2. Configure the Extension

A new profile was created in SwitchyOmega with the following settings to match the proxy service running on the router (PassWall):

*   **Profile Name:** `PassWall` (or any descriptive name)
*   **Profile Type:** `Proxy Profile`
*   **Protocol:** `SOCKS5`
*   **Server:** `192.168.1.2` (The IP address of the router)
*   **Port:** `1082` (The SOCKS5 listening port configured in PassWall)

By selecting this profile in SwitchyOmega, all of Chrome's traffic was successfully forced through the router's proxy.

## Other Attempted Steps

The following standard troubleshooting steps were attempted but did not resolve the issue because the underlying problem was Chrome's failure to detect the system proxy:

*   Disabling "Use secure DNS" in `chrome://settings/security`.
*   Disabling the "Experimental QUIC protocol" in `chrome://flags`.
*   Clearing cache, cookies, and using a new browser profile.
*   Flushing the macOS DNS cache.
